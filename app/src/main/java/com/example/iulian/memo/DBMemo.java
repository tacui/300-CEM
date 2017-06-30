package com.example.iulian.memo;

/**
 * Created by Iulian on 6/30/2017.
 */

public class DBMemo {

    private int _id;
    private String _memotitle;
    private String _memotext;

    public DBMemo() {

    }

    public DBMemo(String memotitle, String memotext) {
        this._memotitle = memotitle;
        this._memotext = memotext;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_memotitle(String _memotitle) {
        this._memotitle = _memotitle;
    }

    public void set_memotext(String _memotext) {
        this._memotext = _memotext;
    }

    public int get_id() {
        return _id;
    }

    public String get_memotitle() {
        return _memotitle;
    }

    public String get_memotext() {
        return _memotext;
    }
}
