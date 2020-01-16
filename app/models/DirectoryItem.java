package models;

import io.ebean.Finder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DirectoryItem extends FileManagerItem {

    @OneToMany(
            mappedBy = "parent",
            fetch = FetchType.EAGER)
    public List<FileItem> childrenFiles = new ArrayList<>();

    @OneToMany(
            mappedBy = "parent",
            fetch = FetchType.EAGER)
    public List<DirectoryItem> childrenDirectories = new ArrayList<>();

    public DirectoryItem(String name, DirectoryItem parent) {
        super(name, parent);
    }

    public static final Finder<Long, DirectoryItem> find = new Finder<>(DirectoryItem.class);

    public static DirectoryItem getById(final Long id) {
        return find.byId(id);
    }

    public DirectoryItem getRoot(){
        DirectoryItem root = this;

        while (root.parent != null) {
            root = getById(root.parent.id);
        }

        return root;
    }
}
