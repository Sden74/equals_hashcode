import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MyItem {
    private final int i;
    private final String s;

    private final MyCallback  callback;

    @Override
    public boolean equals(Object o) {
        callback.equalsCalled();
        if (this == o) return true;
        if (!(o instanceof MyItem myItem)) return false;
        return i == myItem.i && s.equals(myItem.s) && callback.equals(myItem.callback);
    }

    @Override
    public int hashCode() {
        callback.hashCodeCalled();
        return Objects.hash(i, s, callback);
    }

    public MyItem(int i, String s, MyCallback callback) {
        this.i = i;
        this.s = s;
        this.callback = callback;
    }

/*    public MyItem(int i, String s) {
        this.i = i;
        this.s = s;
    }*/

    @Override
    public String toString() {
        return "MyItem{"+
                "i="+i+
                ", s='"+s+'\''+
                "}";
    }
}
