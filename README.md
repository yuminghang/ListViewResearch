1.当setSelection()中的参数小于0，ListView将会选择第0项。
2.当setSelection()中的参数大于数据长度-1时，ListView将会往上滑到最后。
3.其他情况，若ListView还可以往上滑，则选择参数作为显示的第一个条目。
4.否则，ListView将会往上滑到最后。
也就是说，当最后一个条目显示出来时，对于ListView的setSelection()，
将目前完整显示的任意一个条目位置传进去，ListView的现实都不会有变化。

**对于2.3.4**，当setSelection()被调用时都会触发下面这个方法。

```
new AbsListView.OnScrollListener() {

            @Override
            public void onScroll(AbsListView paramAbsListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                Log.e("test", "onScroll");
            }
}
```
**而第一种情况则不会，原因如下，这是setSelection()的调用的底层代码片段**

```
if (position >= 0) {
   setNextSelectedPositionInt(position);
}
```
可以看到只有position > 0才会执行括号里的函数，我估计就是在这个方法里面会触发onScroll方法。
