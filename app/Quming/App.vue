<script>
export default {
	onLaunch: function() {
		console.log('App Launch');
		uni.request({
			url: this.$api.home.vistor,
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

<style lang="scss">
/*每个页面公共css */
@import './uni.scss';
@import './common/iconfont.css';
</style>
