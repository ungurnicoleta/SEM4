// function getAllContent(callbackFunction) {
// 	$.getJSON("ProfileController",
// 		{ action: 'getAllContent'},
// 		callbackFunction
// 	);
// }

// function getUserProfile(userid, callbackFunction) {
// 	$.getJSON("ProfileController",
// 		{ action: 'getUserProfile', userid: userid },
// 		callbackFunction
// 	);
// }
//
function getAllProfiles(callbackFunction) {
	$.getJSON("ProfileController",
		{ action: 'getAll'},
		callbackFunction
	);
}

function addContent(date, title, description, url, callbackFunction) {
	$.post("ProfileController", {action: 'addContent', date: date, title: title, description: description, url: url},
		callbackFunction
	);
}
//
// function getProfiles(name, email, address, age, homeTown, callbackFunction) {
// 	$.getJSON("ProfileController",
// 		{ action: 'getProfiles',
// 			name: name,
// 			email: email,
// 			address: address,
// 			age: age,
// 			homeTown: homeTown},
// 		callbackFunction
// 	);
// }
//
// function updateProfile(date, title, description, url, callbackFunction) {
// 	$.post("ProfileController",
// 		{ action: 'addContent', date: date, title: title, description: description, url: url
// 		},
// 		callbackFunction
// 	);
//  }