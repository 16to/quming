<script>
export default {
	onLaunch: function() {
		console.log('App Launch');
		uni.request({
			url: 'http://localhost:8001/api/visitor',
			method: 'POST',
			data: {
				"client":uni.getSystemInfoSync().platform,
			},
			success: res => {
				console.log(res);
				uni.hideLoading();
			},
			fail: () => {},
			complete: () => {}
		});
		
	},
	onShow: function() {
		console.log('App Show');
	},
	onHide: function() {
		console.log('App Hide');
	}
};
</script>

<style lang="css">
/*每个页面公共css */
@import './common/uni.css';
@import './common/iconfont.css';
</style>
