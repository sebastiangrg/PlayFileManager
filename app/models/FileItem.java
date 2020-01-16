package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class FileItem extends FileManagerItem {

    public FileItem(String name, DirectoryItem parent) {
        super(name, parent);
    }

    public static final Finder<Long, FileItem> find = new Finder<>(FileItem.class);

    public static FileItem getById(final Long id) {
        return find.byId(id);
    }
}
