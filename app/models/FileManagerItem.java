package models;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class FileManagerItem extends AppModel {

    @Id
    public Long id;

    public String name;

    @ManyToOne(fetch = FetchType.EAGER)
    public DirectoryItem parent;

    public FileManagerItem(String name, DirectoryItem parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "FileManagerItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    public List<DirectoryItem> getAncestors() {
        List<DirectoryItem> ancestors = new ArrayList<>();

        DirectoryItem current = parent != null ? DirectoryItem.getById(parent.id) : null;
        while (current != null) {
            ancestors.add(0, current);
            current = current.parent != null ? DirectoryItem.getById(current.parent.id) : null;
        }

        return ancestors;
    }
}
