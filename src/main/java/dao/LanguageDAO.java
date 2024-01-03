package dao;

import entity.film.Language;
import entity.store.Staff;
import org.hibernate.SessionFactory;

public class LanguageDAO extends GenericDAO<Language> {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }

    @Override
    public Language getById(int id) {
        byte languageId = (byte) id;
        return getCurrentSession().get(Language.class, languageId);
    }
}
