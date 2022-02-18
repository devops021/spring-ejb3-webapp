
package com.github.bpark;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class BlogPostDaoBean {

    /** The EntityManager. */
    @PersistenceContext(unitName = "blogpost-persistence")
    private EntityManager entityManager;

    /**
     * Persits a new BlogPost entity.
     *
     * @param blogPost the entity to persist.
     */
    public void persist(BlogPost blogPost) {
        entityManager.persist(blogPost);
    }

    /**
     * Returns all entities.
     *
     * @return list with all entities.
     */
    @SuppressWarnings("unchecked")
    public List<BlogPost> findAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(BlogPost.class));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Finds a specific entity by id.
     *
     * @param id the id.
     * @return the found entity or null if the entity can't be found.
     */
    public BlogPost find(int id) {
        try {
            return entityManager.find(BlogPost.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }
}
