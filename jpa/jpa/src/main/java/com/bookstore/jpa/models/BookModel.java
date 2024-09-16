package com.bookstore.jpa.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.io.Serializable;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisherModel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    @JoinTable(
            name = "TB_BOOK_AUTHOR",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id")
    )
    private Set<AuthorModel> authorModels = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private ReviewModel reviewModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublisherModel getPublisherModel() {
        return publisherModel;
    }

    public void setPublisherModel(PublisherModel publisherModel) {
        this.publisherModel = publisherModel;
    }

    public Set<AuthorModel> getAuthorModels() {
        return authorModels;
    }

    public void setAuthorModels(Set<AuthorModel> authorModels) {
        this.authorModels = authorModels;
    }

    public ReviewModel getReviewModel() {
        return reviewModel;
    }

    public void setReviewModel(ReviewModel reviewModel) {
        this.reviewModel = reviewModel;
    }
}
