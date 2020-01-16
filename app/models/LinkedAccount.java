package models;

import com.feth.play.module.pa.user.AuthUser;
import io.ebean.Finder;

import javax.persistence.*;

@Entity
@Table(name = "linked_accounts")
public class LinkedAccount extends AppModel {

    @Id
    public Long id;

    @ManyToOne
    public User user;

    @Column(unique = true)
    public String providerUserId;

    public String providerKey;

    @OneToOne
    @MapsId
    public DirectoryItem rootDirectory;

    public static final Finder<Long, LinkedAccount> find = new Finder<>(LinkedAccount.class);

    public static LinkedAccount findByProviderKey(final User user, String key) {
        return find.query().where().eq("user", user).eq("providerKey", key)
                .findOne();
    }

    public static LinkedAccount create(final AuthUser authUser) {
        final LinkedAccount ret = new LinkedAccount();

        DirectoryItem userRootDirectory = new DirectoryItem("Home", null);
        userRootDirectory.save();

        ret.rootDirectory = userRootDirectory;

        ret.update(authUser);
        return ret;
    }

    public void update(final AuthUser authUser) {
        this.providerKey = authUser.getProvider();
        this.providerUserId = authUser.getId();
    }

    public static LinkedAccount create(final LinkedAccount acc) {
        final LinkedAccount ret = new LinkedAccount();
        ret.providerKey = acc.providerKey;
        ret.providerUserId = acc.providerUserId;

        DirectoryItem userRootDirectory = new DirectoryItem("Home", null);
        userRootDirectory.save();

        ret.rootDirectory = userRootDirectory;

        return ret;
    }
}
