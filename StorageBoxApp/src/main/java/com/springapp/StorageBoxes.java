package com.springapp;

import javax.persistence.*;

@Entity(name = "storageboxes")
@Table(name = "storageboxes")
public class StorageBoxes {
    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "folder", nullable = false)
    private String folder;

    @Column(name = "tags", nullable = false)
    private String tags;

    @Column(name = "file", nullable = false)
    private String file;

    @Column(name = "myid", nullable = false)
    private Integer myid;

    @Column(name = "id", nullable = false)
    public Integer id;

    public StorageBoxes() {
    }

    @Override
    public String toString()
    {
        String returnStr;
        returnStr="Category,"+category+",folder,"+folder+",tags,"+tags+",file,"+file+",id,"+id+",myid,"+myid+"\n";
        return returnStr;
    }

    public StorageBoxes(String category, String folder, String tags, String filenm, Integer myid) {
        this.category = category;
        this.folder = folder;
        this.tags = tags;
        this.file = filenm;
        this.myid = myid;
    }
//TODO: test: do not use @Id column in custom SQL statements?  might work, now that it was renamed from itemid to id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getFolder() {
        return folder;
    }

    public String getTags() {
        return tags;
    }

    public String getFile() {
        return file;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getMyid() {
        return myid;
    }

    public void setMyid(Integer myid) {
        this.myid = myid;
    }
}

