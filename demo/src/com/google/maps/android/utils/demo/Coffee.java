package com.google.maps.android.utils.demo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class Coffee implements ClusterItem {
    public final String name;
    public final int profilePhoto;
    private final LatLng mPosition;

    public Coffee(LatLng position, String name, int pictureResource) {
        this.name = name;
        profilePhoto = pictureResource;
        mPosition = position;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
