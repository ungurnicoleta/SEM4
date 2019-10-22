

function getAllTopics(callbackFunction) {
	$.getJSON(
		"TopicsController",
		{ action: 'getAll' },
	 	callbackFunction
	);
}

function addTopic(username, name, description, callbackFunction) {
    $.get("TopicsController",
		{
			action: "add",
			username: username,
			name: name,
			description: description
		},
		callbackFunction
	);
}

function getCommentsOfTopic(topicID, callbackFunction) {
    $.getJSON(
        "CommentsController",
        { topicID: topicID },
        callbackFunction
    );
}

function loadCommentsOfTopic(topicID, callbackFunction) {
    $.get("CommentsController",
        {
            action: "get",
            topicID: topicID
        },
        callbackFunction
    );
}

function addComment(topicID, author, text, callbackFunction) {
    $.get("CommentsController",
        {
            action: "add",
            topicID: topicID,
            author: author,
            text: text
        },
        callbackFunction
    );
}

function deleteComment(username, commentID, callbackFunction) {
    $.get("CommentsController",
        {
            action: "delete",
            username: username,
            commentID: commentID
        },
        callbackFunction
    );
}

function searchAllComments(wantedString, callbackFunction) {
    $.get("CommentsController",
        {
            action: "searchComments",
            wantedString: wantedString
        },
        callbackFunction
    );
}
