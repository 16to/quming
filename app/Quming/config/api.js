let root = "http://localhost:8000";
let apiRoot = root + '/api/';
let uploadRoot = root + '/upload/';
let api = {
	apiRoot: apiRoot,
	uploadRoot: uploadRoot,
	home: {
		vistor: apiRoot + 'visitor',
		postor: apiRoot + "postor",
		banner: apiRoot + "banner?page=1&pageSize=3",
	},

};
export default api;
