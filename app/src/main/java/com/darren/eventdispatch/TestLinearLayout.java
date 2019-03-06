package com.darren.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class TestLinearLayout extends LinearLayout {
    public TestLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("TAG", "TestLinearLayout onInterceptTouchEvent-- action=" + ev.getAction());
        if(ev.getAction()==MotionEvent.ACTION_DOWN){
            return  false;
        }
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("TAG", "TestLinearLayout dispatchTouchEvent-- action=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "TestLinearLayout onTouchEvent-- action=" + event.getAction());

        return true;
    }


	/*dispatchTransformedTouchEvent 会递归调用，调用者必须是ViewGroup
	如果child不为null，则会调用该child的dispatchTouchEvent，一直递归下去
	假如现在是分发到了触摸到的最里层view的父亲viewGroup中，分两种情况
	1.最后的child是view,这时会调到view的dispatchTouchEvent，然后是onTouchEvent方法
    2.最后的child是viewGroup，这时会调到viewGroup的dispatchTouchEvent，然后child为null，
    接着dispatchTransformedTouchEvent，然后调用viewGroup父类view的dispatchTouchEvent，接着
    调用viewGroup的onTouchEvent方法（多态）*/

    /*1.加入的最后的child的dispatchTouchEvent返回false（直接调super一样），这时倒数第二层的ViewGroup的
    dispatchTransformedTouchEvent会返回false，if里面的代码不会走，mFirstTouchTarget会等于null，这时代码走下去会继续调用
    dispatchTransformedTouchEvent,此时传入的child是null,所以这时会调用viewGroup父类view的dispatchTouchEvent，接着
    调用viewGroup的onTouchEvent方法（多态）（接着会回溯上去，如果都是调super实现的话，最终会到顶层viewDevorView的onTouchEvent方法，再到Activity的onTouchEvent方法。（此时down事件走完）
    结论1：dispatchTouchEvent 和 onTouchEvent return false的时候事件都回传给父控件的onTouchEvent处理。*/


    /*2.加入的最后的child的dispatchTouchEvent返回true，这时倒数第二层的ViewGroup的
    dispatchTransformedTouchEvent会返回true，if里面的代码会走，mFirstTouchTarget就不为null，这时代码走下去，handled为true，
    接着会回溯上去（倒数第二层的mFirstTouchTarget为倒数第一层的view，倒数第三层的mFirstTouchTarget为倒数第二层的view（倒数第三层handled也为true））
    结论2：dispatchTouchEvent 和 onTouchEvent 一旦return true,事件就停止传递了（到达终点）（没有谁能再收到这个事件）。
     看下图中只要return true事件就没再继续传下去了，对于return true我们经常说事件被消费了，消费了的意思就是事件走到这里就是终点，不会往下传，没有谁能再收到这个事件了（此时down事件不会传到父控件的onTouchEvent中）
     （这里有一个注意点，同一个view,onTouchEvent返回true,如果dispatchTouchEvent方法返回调用的是super.dispatchTouchEvent,这dispatchTouchEvent也会返回true,其他情况则不一定）
    */
    /*3.加入的最后的child的dispatchTouchEvent返回true,一般来说，父控件就不走onTouchEvent?有没办法实现走父控件的onTouchEvent呢?
    有，在父控件的onInterceptTouchEvent方法返回true.此时不会去寻找触摸到的childWithAccessibilityFocus，mFirstTouchTarget为null，这时代码走下去会继续调用
    dispatchTransformedTouchEvent,此时传入的child是null,所以这时会调用viewGroup父类view的dispatchTouchEvent，接着
    调用viewGroup的onTouchEvent方法（多态），然后回溯，这时加入最后的chid就不会受到事件，不会走dispatchTouchEvent
    */
    /*4.父控件的onInterceptTouchEvent返回true，表示父控件拦截了事件，子类就再也收不到事件，有没办法在该情况下，子view也能受到事件呢？
      有的，但是有一个前提，父控件不能拦截actionDown事件，因为父控件拦截actionDown后，事件走不到子view中，你在actiondown事件前设置的不允许父控件拦截标志位，会在actiondown中被重置
      所以一般做法是在父控件onInterceptTouchEvent方法中，如果actionDown事件返回false，其他事件返回true。然后在子view的dispatchTouchEvent的actionDown调用 getParent().requestDisallowInterceptTouchEvent(true)，true表示不允许父控件拦截。(注意，如果子view没有调用getParent().requestDisallowInterceptTouchEvent(true)方法，子view不会受到move 和up事件，会收到cancel事件)
      (这里还有一个注意点，因为down事件返回false，此时也不会调用父控件的onTouchEvent方法。）
     */
    /*
     5.view事件分发给自己的onTouchEvent 处理呢，那只能return super.dispatchTouchEvent,View类的dispatchTouchEvent（）方法默认实现就是能帮你调用View自己的onTouchEvent方法的。然后ViewGroup怎样通过dispatchTouchEvent方法能把事件分发到自己的onTouchEvent处理呢，return true和false 都不行，那么只能通过Interceptor把事件拦截下来给自己的onTouchEvent，所以ViewGroup dispatchTouchEvent方法的super默认实现就是去调用onInterceptTouchEvent
     */
    /*
     6.ViewGroup和View的onTouchEvent方法是做事件处理的，那么这个事件只能有两个处理
     (1、自己消费掉，事件终结，不再传给谁----->return true;
       2、继续从下往上传，不消费事件，让父View也能收到到这个事件----->return false;View的默认实现是不消费的。所以super==false。)
     */

/*     if (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign)) {
		// Child wants to receive touch within its bounds.
		mLastTouchDownTime = ev.getDownTime();
		if (preorderedList != null) {
			// childIndex points into presorted list, find original index
			for (int j = 0; j < childrenCount; j++) {
				if (children[childIndex] == mChildren[j]) {
					mLastTouchDownIndex = j;
					break;
				}
			}
		} else {
			mLastTouchDownIndex = childIndex;
		}
		mLastTouchDownX = ev.getX();
		mLastTouchDownY = ev.getY();
		newTouchTarget = addTouchTarget(child, idBitsToAssign);
		alreadyDispatchedToNewTouchTarget = true;
		break;
	}
	 private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
			 if (child == null) {
                handled = super.dispatchTouchEvent(event);
            } else {
                handled = child.dispatchTouchEvent(event);
            }
	}
	*/


/*	 if (mFirstTouchTarget == null) {
		// No touch targets so treat this as an ordinary view.
		handled = dispatchTransformedTouchEvent(ev, canceled, null,
				TouchTarget.ALL_POINTER_IDS);
	} else {
		// Dispatch to touch targets, excluding the new touch target if we already
		// dispatched to it.  Cancel touch targets if necessary.
		TouchTarget predecessor = null;
		TouchTarget target = mFirstTouchTarget;
		while (target != null) {
			final TouchTarget next = target.next;
			if (alreadyDispatchedToNewTouchTarget && target == newTouchTarget) {
				handled = true;
			} else {
				final boolean cancelChild = resetCancelNextUpFlag(target.child)
						|| intercepted;
				if (dispatchTransformedTouchEvent(ev, cancelChild,
						target.child, target.pointerIdBits)) {
					handled = true;
				}
				if (cancelChild) {
					if (predecessor == null) {
						mFirstTouchTarget = next;
					} else {
						predecessor.next = next;
					}
					target.recycle();
					target = next;
					continue;
				}
			}
			predecessor = target;
			target = next;
		}
	}*/


}