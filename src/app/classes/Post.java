package app.classes;

import java.time.LocalDateTime;

public class Post {
    User user;
    String title, content;
    LocalDateTime date;
    boolean ageRestriction;

//----------------------------------------------------------------------

    public Post(User user, String title, String content, LocalDateTime date) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
    }

//----------------------------------------------------------------------

    public User getUser() {
        return user;
    }
    public void setUse(User user) {
        this.user = user;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public boolean getAgeRestriction() {
        return ageRestriction;
    }
    public void setAgeRestriction(String siOno) {
        if (siOno.equalsIgnoreCase("si")){
            this.ageRestriction = true;
        }
    }

//----------------------------------------------------------------------

    public static Post createpost(User usuariPostm, String[] post) {
        Post newPost = new Post(usuariPostm, post[0], post[1], LocalDateTime.now());
        newPost.setAgeRestriction(post[2]);
        return newPost;
    }



}