package hexlet.code;

import java.util.List;

public final class DiffChange {
    private String key;
    private String typeChange;
    private Object oldValue;
    private Object newValue;
    private List<DiffChange> children;

    public DiffChange(String key, String typeChange, Object oldValue,
                      Object newValue, List<DiffChange> children) {
        this.key = key;
        this.typeChange = typeChange;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.children = children;
    }

    public String getKey() {
        return key;
    }

    public String getTypeChange() {
        return typeChange;
    }
    public Object getValue() {
        if ("unchanged".equals(typeChange)) {
            return oldValue;
        }
        return null;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public List<DiffChange> getChildren() {
        return children;
    }

    public boolean isNested() {
        return "nested".equals(typeChange);
    }
}
