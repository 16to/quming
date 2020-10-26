<script>
	export default {
		onLaunch: function() {
			console.log('App Launch1')
		},
		onShow: function() {
			console.log('App Show2')
		},
		onHide: function() {
			console.log('App Hide3')
		}
	}
</script>

<style>
	/*每个页面公共css */
	@import url("./common/uni.css");

	.uni-media-list-body {
		height: auto;
	}

	.uni-media-list-text-top {
		line-height: 1.6em;
	}
</style>
