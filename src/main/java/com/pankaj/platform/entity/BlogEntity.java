/*
package com.pankaj.platform.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

*/
/**
 * Created by pankajpardasani on 17/07/2016.
 *//*


@Entity
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column
    private String title;
    @Column
    private String detailEntry;
    @Column
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailEntry() {
        return detailEntry;
    }

    public void setDetailEntry(String detailEntry) {
        this.detailEntry = detailEntry;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogEntity)) return false;
        BlogEntity that = (BlogEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
*/
