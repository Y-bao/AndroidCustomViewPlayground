package cn.bingoogolapple.acvp.refreshlayout.widget;

import android.content.Context;
import android.view.View;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/21 12:56
 * 描述:
 */
public abstract class BGARefreshViewHolder {
    /**
     * 手指移动距离与下拉刷新控件paddingTop移动距离的比值
     */
    private static final float PADDING_TOP_SCALE = 1.8f;
    /**
     * 下拉刷新控件paddingTop的弹簧距离与下拉刷新控件高度的比值
     */
    private static final float SPRING_DISTANCE_SCALE = 0.4f;

    protected Context mContext;
    /**
     * 下拉刷新控件
     */
    protected View mRefreshHeaderView;
    /**
     * 上拉加载更多控件
     */
    protected View mLoadMoreFooterView;

    public BGARefreshViewHolder(Context context) {
        mContext = context;
    }

    /**
     * 获取上拉加载更多控件
     *
     * @return
     */
    public abstract View getLoadMoreFooterView();

    /**
     * 获取下拉刷新控件
     *
     * @return
     */
    public abstract View getRefreshHeaderView();

    /**
     * 下拉刷新控件可见时，处理上下拉进度
     *
     * @param scale         下拉过程0 ==> 1
     * @param moveYDistance
     */
    public abstract void handleScale(float scale, int moveYDistance);

    /**
     * 进入到未处理下拉刷新状态
     */
    public abstract void changeToIdle();

    /**
     * 进入下拉刷新状态
     */
    public abstract void changeToPullDown();

    /**
     * 进入释放刷新状态
     */
    public abstract void changeToReleaseRefresh();

    /**
     * 进入正在刷新状态
     */
    public abstract void changeToRefreshing();

    /**
     * 结束上拉加载更多
     */
    public abstract void onEndLoadingMore();

    /**
     * 结束下拉刷新
     */
    public abstract void onEndRefreshing();

    /**
     * 手指移动距离与下拉刷新控件paddingTop移动距离的比值
     *
     * @return
     */
    public float getPaddingTopScale() {
        return PADDING_TOP_SCALE;
    }

    /**
     * 下拉刷新控件paddingTop的弹簧距离与下拉刷新控件高度的比值
     *
     * @return
     */
    public float getSpringDistanceScale() {
        return SPRING_DISTANCE_SCALE;
    }

    /**
     * 是处于能够进入刷新状态
     *
     * @return
     */
    public boolean canChangeToRefreshingStatus() {
        return false;
    }

    /**
     * 获取下拉刷新控件的高度，如果初始化时的高度和最后展开的最大高度不一致，需重写该方法返回最大高度
     *
     * @return
     */
    public int getRefreshHeaderViewHeight() {
        if (mRefreshHeaderView != null) {
            // 测量下拉刷新控件的高度
            mRefreshHeaderView.measure(0, 0);
            return mRefreshHeaderView.getMeasuredHeight();
        }
        return 0;
    }

}