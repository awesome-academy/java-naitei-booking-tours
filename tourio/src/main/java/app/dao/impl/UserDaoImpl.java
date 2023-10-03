package app.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import app.dao.UserDao;
import app.entity.User;

@Repository("userDaoImpl")
@SuppressWarnings("unchecked")
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate template;

	@Override
	public boolean add(User user) {
		return template.save(user) != null;
	}

	@Override
	public boolean update(User user) {
		return template.merge(user) != null;
	}

	@Override
	public User get(Integer userId) {
		return template.get(User.class, userId);
	}

	@Override
	public User get(String email) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("email", email));
		List<User> users = (List<User>) template.findByCriteria(dc);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public void delete(Integer userId) {
		User user = (User) template.load("User", userId, LockMode.PESSIMISTIC_WRITE);
		template.delete(user);
	}

	@Override
	public List<User> getAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		return (List<User>) template.findByCriteria(dc);
	}

}
