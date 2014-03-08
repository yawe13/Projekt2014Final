/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.commentservice.dao;

import fh.ostfalia.projekt2014.commentservice.entities.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author KingDCB
 */
@Stateless
public class CommentDao {

    @PersistenceContext
    private EntityManager em;

    public void addComment(Comment comment) {
             em.persist(comment);       
    }
    
    private Comment getComment(int cId) {
        return em.find(Comment.class, cId);
    }

    public Comment getCommentByMp3Id(int mp3Id) {
        return em.find(Comment.class, mp3Id);
    }

    public Comment getCommentByMp3ArtistId(int mp3ArtistId) {
        return em.find(Comment.class, mp3ArtistId);
    }

    public void deleteComment(int cId) {
        em.remove(getComment(cId));
    }

}
