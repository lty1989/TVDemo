package com.lty.tvdemo.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.lty.tvdemo.MyApplication;
import com.lty.tvdemo.R;
import com.lty.tvdemo.utils.UIUtil;


public class PercentLayoutHelper {
    private static final String TAG = "PercentLayout";

    private static final boolean DEBUG = false;
    private static final boolean VERBOSE = false;

    private final ViewGroup mHost;

    public PercentLayoutHelper(@NonNull ViewGroup host) {
        if (host == null) {
            throw new IllegalArgumentException("host must be non-null");
        }
        mHost = host;
    }


    static void fetchWidthAndHeight(ViewGroup.LayoutParams params, TypedArray array,
                                    int widthAttr, int heightAttr) {
        params.width = array.getLayoutDimension(widthAttr, 0);
        params.height = array.getLayoutDimension(heightAttr, 0);
    }


    public void adjustChildren(int widthMeasureSpec, int heightMeasureSpec) {
        if (DEBUG) {
            Log.d(TAG, "adjustChildren: " + mHost + " widthMeasureSpec: "
                    + View.MeasureSpec.toString(widthMeasureSpec) + " heightMeasureSpec: "
                    + View.MeasureSpec.toString(heightMeasureSpec));
        }

        // Calculate available space, accounting for host's paddings
        int widthHint = View.MeasureSpec.getSize(widthMeasureSpec) - mHost.getPaddingLeft()
                - mHost.getPaddingRight();
        int heightHint = View.MeasureSpec.getSize(heightMeasureSpec) - mHost.getPaddingTop()
                - mHost.getPaddingBottom();
        for (int i = 0, N = mHost.getChildCount(); i < N; i++) {
            View view = mHost.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (DEBUG) {
                Log.d(TAG, "should adjust " + view + " " + params);
            }
            if (params instanceof PercentLayoutParams) {
                PercentLayoutInfo info =
                        ((PercentLayoutParams) params).getPercentLayoutInfo();
                if (DEBUG) {
                    Log.d(TAG, "using " + info);
                }
                if (info != null) {
                    if (params instanceof ViewGroup.MarginLayoutParams) {
                        info.fillMarginLayoutParams(view, (ViewGroup.MarginLayoutParams) params,
                                widthHint, heightHint);
                    } else {
                        info.fillLayoutParams(params, widthHint, heightHint);
                    }
                }
            }
        }
    }


    public static PercentLayoutInfo getPercentLayoutInfo(Context context,
                                                         AttributeSet attrs) {
        PercentLayoutInfo info = null;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PercentLayout_Layout);
        int value = array.getInt(R.styleable.PercentLayout_Layout_layout_widthPercent, -1);
        if (value != -1) {
            if (VERBOSE) {
                Log.v(TAG, "percent width: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.widthPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_heightPercent, -1);
        if (value != -1) {
            if (VERBOSE) {
                Log.v(TAG, "percent height: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.heightPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.leftMarginPercent = value;
            info.topMarginPercent = value;
            info.rightMarginPercent = value;
            info.bottomMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginLeftPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent left margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.leftMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginTopPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent top margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.topMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginRightPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent right margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.rightMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginBottomPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent bottom margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.bottomMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginStartPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent start margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.startMarginPercent = value;
        }
        value = array.getInt(R.styleable.PercentLayout_Layout_layout_marginEndPercent, -1);
        if (value != -1f) {
            if (VERBOSE) {
                Log.v(TAG, "percent end margin: " + value);
            }
            info = info != null ? info : new PercentLayoutInfo();
            info.endMarginPercent = value;
        }


        array.recycle();
        if (DEBUG) {
            Log.d(TAG, "constructed: " + info);
        }
        return info;
    }

    public void restoreOriginalParams() {
        for (int i = 0, N = mHost.getChildCount(); i < N; i++) {
            View view = mHost.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (DEBUG) {
                Log.d(TAG, "should restore " + view + " " + params);
            }
            if (params instanceof PercentLayoutParams) {
                PercentLayoutInfo info =
                        ((PercentLayoutParams) params).getPercentLayoutInfo();
                if (DEBUG) {
                    Log.d(TAG, "using " + info);
                }
                if (info != null) {
                    if (params instanceof ViewGroup.MarginLayoutParams) {
                        info.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams) params);
                    } else {
                        info.restoreLayoutParams(params);
                    }
                }
            }
        }
    }


    public boolean handleMeasuredStateTooSmall() {
        boolean needsSecondMeasure = false;
        for (int i = 0, N = mHost.getChildCount(); i < N; i++) {
            View view = mHost.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (DEBUG) {
                Log.d(TAG, "should handle measured state too small " + view + " " + params);
            }
            if (params instanceof PercentLayoutParams) {
                PercentLayoutInfo info =
                        ((PercentLayoutParams) params).getPercentLayoutInfo();
                if (info != null) {
                    if (shouldHandleMeasuredWidthTooSmall(view, info)) {
                        needsSecondMeasure = true;
                        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    }
                    if (shouldHandleMeasuredHeightTooSmall(view, info)) {
                        needsSecondMeasure = true;
                        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    }
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "should trigger second measure pass: " + needsSecondMeasure);
        }
        return needsSecondMeasure;
    }

    private static boolean shouldHandleMeasuredWidthTooSmall(View view, PercentLayoutInfo info) {
        int state = view.getMeasuredWidthAndState() & View.MEASURED_STATE_MASK;
        return state == View.MEASURED_STATE_TOO_SMALL && info.widthPercent >= 0
                && info.mPreservedParams.width == ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    private static boolean shouldHandleMeasuredHeightTooSmall(View view, PercentLayoutInfo info) {
        int state = view.getMeasuredHeightAndState() & View.MEASURED_STATE_MASK;
        return state == View.MEASURED_STATE_TOO_SMALL && info.heightPercent >= 0
                && info.mPreservedParams.height == ViewGroup.LayoutParams.WRAP_CONTENT;
    }

    /* package */ static class PercentMarginLayoutParams extends ViewGroup.MarginLayoutParams {
        // These two flags keep track of whether we're computing the LayoutParams width and height
        // in the fill pass based on the aspect ratio. This allows the fill pass to be re-entrant
        // as the framework code can call onMeasure() multiple times before the onLayout() is
        // called. Those multiple invocations of onMeasure() are not guaranteed to be called with
        // the same set of width / height.
        private boolean mIsHeightComputedFromAspectRatio;
        private boolean mIsWidthComputedFromAspectRatio;

        public PercentMarginLayoutParams(int width, int height) {
            super(width, height);
        }
    }


    public static class PercentLayoutInfo {
        /**
         * The decimal value of the percentage-based width.
         */
        public int widthPercent;

        /**
         * The decimal value of the percentage-based height.
         */
        public int heightPercent;

        /**
         * The decimal value of the percentage-based left margin.
         */
        public int leftMarginPercent;

        /**
         * The decimal value of the percentage-based top margin.
         */
        public int topMarginPercent;

        /**
         * The decimal value of the percentage-based right margin.
         */
        public int rightMarginPercent;

        /**
         * The decimal value of the percentage-based bottom margin.
         */
        public int bottomMarginPercent;

        /**
         * The decimal value of the percentage-based start margin.
         */
        public int startMarginPercent;

        /**
         * The decimal value of the percentage-based end margin.
         */
        public int endMarginPercent;


        /* package */ final PercentMarginLayoutParams mPreservedParams;

        public PercentLayoutInfo() {
            widthPercent = -1;
            heightPercent = -1;
            leftMarginPercent = -1;
            topMarginPercent = -1;
            rightMarginPercent = -1;
            bottomMarginPercent = -1;
            startMarginPercent = -1;
            endMarginPercent = -1;
            mPreservedParams = new PercentMarginLayoutParams(0, 0);
        }

        /**
         * Fills the {@link ViewGroup.LayoutParams#width} and {@link ViewGroup.LayoutParams#height}
         * fields of the passed {@link ViewGroup.LayoutParams} object based on currently set
         * percentage values.
         */
        public void fillLayoutParams(ViewGroup.LayoutParams params, int widthHint,
                                     int heightHint) {
            // Preserve the original layout params, so we can restore them after the measure step.
            mPreservedParams.width = params.width;
            mPreservedParams.height = params.height;

            // We assume that width/height set to 0 means that value was unset. This might not
            // necessarily be true, as the user might explicitly set it to 0. However, we use this
            // information only for the aspect ratio. If the user set the aspect ratio attribute,
            // it means they accept or soon discover that it will be disregarded.
            final boolean widthNotSet =
                    (mPreservedParams.mIsWidthComputedFromAspectRatio
                            || mPreservedParams.width == 0) && (widthPercent < 0);
            final boolean heightNotSet =
                    (mPreservedParams.mIsHeightComputedFromAspectRatio
                            || mPreservedParams.height == 0) && (heightPercent < 0);

            if (widthPercent >= 0) {
                params.width = Math.round(UIUtil.getScreenWidth(MyApplication.getInstance()) * widthPercent / UIUtil.sSTAND_WIDTH);
            }

            if (heightPercent >= 0) {
                params.height = Math.round(UIUtil.getScreenHeight(MyApplication.getInstance()) * heightPercent / UIUtil.sSTAND_HEIGHT);
            }


            if (DEBUG) {
                Log.d(TAG, "after fillLayoutParams: (" + params.width + ", " + params.height + ")");
            }
        }


        public void fillMarginLayoutParams(ViewGroup.MarginLayoutParams params,
                                           int widthHint, int heightHint) {
            fillMarginLayoutParams(null, params, widthHint, heightHint);
        }


        public void fillMarginLayoutParams(View view, ViewGroup.MarginLayoutParams params,
                                           int widthHint, int heightHint) {
            fillLayoutParams(params, widthHint, heightHint);


            // Preserve the original margins, so we can restore them after the measure step.
            mPreservedParams.leftMargin = params.leftMargin;
            mPreservedParams.topMargin = params.topMargin;
            mPreservedParams.rightMargin = params.rightMargin;
            mPreservedParams.bottomMargin = params.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(mPreservedParams,
                    MarginLayoutParamsCompat.getMarginStart(params));
            MarginLayoutParamsCompat.setMarginEnd(mPreservedParams,
                    MarginLayoutParamsCompat.getMarginEnd(params));

            if (leftMarginPercent >= 0) {
                params.leftMargin = Math.round(UIUtil.getScreenWidth(MyApplication.getInstance()) * leftMarginPercent / UIUtil.sSTAND_WIDTH);
            }
            if (topMarginPercent >= 0) {
                params.topMargin = Math.round(UIUtil.getScreenHeight(MyApplication.getInstance()) * topMarginPercent / UIUtil.sSTAND_HEIGHT);
            }
            if (rightMarginPercent >= 0) {
                params.rightMargin = Math.round(UIUtil.getScreenWidth(MyApplication.getInstance()) * rightMarginPercent / UIUtil.sSTAND_WIDTH);
            }
            if (bottomMarginPercent >= 0) {
                params.bottomMargin = Math.round(UIUtil.getScreenHeight(MyApplication.getInstance()) * bottomMarginPercent / UIUtil.sSTAND_HEIGHT);

            }
            boolean shouldResolveLayoutDirection = false;
            if (startMarginPercent >= 0) {
                MarginLayoutParamsCompat.setMarginStart(params,
                        Math.round(Math.round(UIUtil.getScreenWidth(MyApplication.getInstance()) * startMarginPercent / UIUtil.sSTAND_WIDTH)));
                shouldResolveLayoutDirection = true;
            }
            if (endMarginPercent >= 0) {
                MarginLayoutParamsCompat.setMarginEnd(params,
                        Math.round(Math.round(UIUtil.getScreenWidth(MyApplication.getInstance()) * endMarginPercent / UIUtil.sSTAND_WIDTH)));
                shouldResolveLayoutDirection = true;
            }
            if (shouldResolveLayoutDirection && (view != null)) {
                // Force the resolve pass so that start / end margins are propagated to the
                // matching left / right fields
                MarginLayoutParamsCompat.resolveLayoutDirection(params,
                        ViewCompat.getLayoutDirection(view));
            }
            if (DEBUG) {
                Log.d(TAG, "after fillMarginLayoutParams: (" + params.width + ", " + params.height
                        + ")");
            }
        }

        @Override
        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f, "
                            + " %f, %f, %f, %f)", widthPercent, heightPercent, leftMarginPercent,
                    topMarginPercent, rightMarginPercent, bottomMarginPercent, startMarginPercent,
                    endMarginPercent);

        }


        public void restoreMarginLayoutParams(ViewGroup.MarginLayoutParams params) {
            restoreLayoutParams(params);
            params.leftMargin = mPreservedParams.leftMargin;
            params.topMargin = mPreservedParams.topMargin;
            params.rightMargin = mPreservedParams.rightMargin;
            params.bottomMargin = mPreservedParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(params,
                    MarginLayoutParamsCompat.getMarginStart(mPreservedParams));
            MarginLayoutParamsCompat.setMarginEnd(params,
                    MarginLayoutParamsCompat.getMarginEnd(mPreservedParams));
        }


        public void restoreLayoutParams(ViewGroup.LayoutParams params) {
            if (!mPreservedParams.mIsWidthComputedFromAspectRatio) {
                // Only restore the width if we didn't compute it based on the height and
                // aspect ratio in the fill pass.
                params.width = mPreservedParams.width;
            }
            if (!mPreservedParams.mIsHeightComputedFromAspectRatio) {
                // Only restore the height if we didn't compute it based on the width and
                // aspect ratio in the fill pass.
                params.height = mPreservedParams.height;
            }

            // Reset the tracking flags.
            mPreservedParams.mIsWidthComputedFromAspectRatio = false;
            mPreservedParams.mIsHeightComputedFromAspectRatio = false;
        }
    }


    public interface PercentLayoutParams {
        PercentLayoutInfo getPercentLayoutInfo();
    }
}
