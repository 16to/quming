<template>
	<view>
		<uni-nav-bar left-icon="back" @clickLeft="backHome" @clickRight="toFav" left-text="返回" right-text="收藏列表" title="名字列表">
		</uni-nav-bar>
		<view>
			<uni-card title="Dcloud" extra="true" @click="toDetail(0)">
				那是一个秋意盎然、金风送爽的日子,我和父母一起来到了位于上师大旁的康健园.一踏进公园,一股浓郁的桂香扑鼻而来,泌人心脾,让我心旷神怡,只见一朵朵开得正烈的金色桂花,迎风而立,仿佛在向我招手.我们追着这桂香,走进了清幽的公园.
				<template v-slot:extra>
					<view @tap.stop="favClick(0)">
						<uni-fav :checked="checkList[0]" class="favBtn" />
					</view>
				</template>
				<view class="children" @tap.stop="favClick(0)">123</view>
			</uni-card>
			<uni-load-more :status="more" :contentText="contentText"></uni-load-more>
		</view>
	</view>
</template>

<script>
	import uniNavBar from "@/components/uni-nav-bar/uni-nav-bar.vue"
	import uniCard from '@/components/uni-card/uni-card.vue'
	import uniLoadMore from "@/components/uni-load-more/uni-load-more.vue"
	import uniFav from '@/components/uni-fav/uni-fav.vue'
	export default {
		components: {
			uniNavBar,
			uniCard,
			uniLoadMore,
			uniFav
		},
		data() {
			return {
				nbTitle: '标题',
				titleIcon: '/static/logo.png',
				titleIconRadius: '20px',
				subtitleText: 'subtitleText',
				nbLoading: false,
				nbFrontColor: '#000000',
				nbBackgroundColor: '#ffffff',
				contentText: {
					contentdown: "加载更多名字"
				},
				more: "more",
				fav: 123,
				checkList: [false, false, false, false, false, false],
			}
		},
		methods: {
			// 跳转到 tabBar 页面只能使用 switchTab 跳转
			backHome() {
				uni.switchTab({
					url: '/pages/home/index',
				});
			},
			// 跳到加入收藏
			toFav() {
				uni.navigateTo({
					url: '/pages/home/fav',
				});
			},
			// 跳转到详情
			toDetail(index) {
				uni.navigateTo({
					url: '/pages/home/detail?id='+index,
				});
			},
			// 点击收藏
			favClick(index) {
				this.checkList[index] = !this.checkList[index]
				this.$forceUpdate()
			}
		}
	}
</script>

<style>

</style>
