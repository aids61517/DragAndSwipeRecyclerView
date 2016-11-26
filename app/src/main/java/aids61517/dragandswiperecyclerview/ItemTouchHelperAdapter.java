package aids61517.dragandswiperecyclerview;

/**
 * Created by deming_huang on 2016/8/3.
 */
public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
