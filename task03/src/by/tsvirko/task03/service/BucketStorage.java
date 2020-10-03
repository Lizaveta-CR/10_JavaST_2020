package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Bucket;

import java.util.ArrayList;
import java.util.List;

public class BucketStorage {
    private List<Bucket> buckets;

    public BucketStorage() {
        this.buckets = new ArrayList<>();
    }

    //TODO: getBuskets(int i)
    public List<Bucket> getBuckets() {
        return buckets;
    }

    public void setBucket(Bucket bucket) {
        buckets.add(bucket);
    }
}
