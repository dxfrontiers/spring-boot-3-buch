package de.springbootbuch.graphql;

import de.springbootbuch.graphql.repo.Comment;

public record CommentAddedEvent(Comment comment) {
}
