package com.myapplication.Utility;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref modesetUserId
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "MyShop";
    private static final String PUSER_ID = "UserID";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String SYNC_DATE_DOWNLOAD = "SyncDateDownload";
    private static final String SYNC_DATE_BRANCH = "SyncDateBranchDownload";
    private static final String SYNC_DATE_OFFERNEWS = "SyncDateOfferNewsDownload";
    private static final String SYNC_DATE_SERVICES = "SyncDateServices";

    private static final String COUNT_RECORD_BLOGS = "CountRecordBlogs";
    private static final String COUNT_RECORD_BRANCHES = "CountRecordBranches";
    private static final String COUNT_RECORD_OFFERSNEWS = "CountRecordOffersNews";
    private static final String COUNT_SERVICES = "CountServices";
    private static final String BILL_INVOICE_PREFIX = "BillPreFix";
    private static final String BILL_Invoice_Edit = "Billinvoiceedit";
    private static final String INVOICE_ID = "orderitem";
    private static final String USER_DATA = "userdata";
    private static final String BILL_DATA = "billdata";
    private static final String USER_ID = "userid";
    public void setUserData(String _user) {
        editor.putString(USER_DATA, _user);
        editor.commit();
    }
    public void setBillData(String _bill) {
        editor.putString(BILL_DATA, _bill);
        editor.commit();
    }
    public String getBillData() {
        return pref.getString(BILL_DATA, "");
    }

    public void setUserDatadel(String _user) {
        editor.putString(USER_DATA, _user);
        editor.clear();
        editor.commit();
    }
    public String getUserData() {
        return pref.getString(USER_DATA, "");
    }
    public void setUserId(String _userid) {
        editor.putString(USER_ID, _userid);
        editor.commit();
    }
    public String getUserId() {
        return pref.getString(USER_ID, "");
    }
    public void setInvoiceId(String _order) {
        editor.putString(INVOICE_ID, _order);
        editor.commit();
    }
    public String getInvoiceId() {
        return pref.getString(INVOICE_ID, "");
    }

    public SharedPreferences getPref() {
        return pref;
    }

    public void setPref(SharedPreferences pref) {
        this.pref = pref;
    }

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setuPassword(String _pass) {
        editor.putString("pass", _pass);
        editor.commit();
    }
    public String getuPassword() {
        return pref.getString("pass", "");
    }

    public void setPUSERID(String _userid) {
        editor.putString(PUSER_ID, _userid).commit();

    }

    public String getPUSERID() {
        return pref.getString(PUSER_ID, "");
    }
    public void setSyncDateDownload(String _SyncDateDownload) {
        editor.putString(SYNC_DATE_DOWNLOAD, _SyncDateDownload);
        editor.commit();
    }
    public String getSyncDateDownload() {
        return pref.getString(SYNC_DATE_DOWNLOAD, "");
    }

    public void setSyncDateOfferNewsDownload(String _SyncDateOfferNewsDownload) {
        editor.putString(SYNC_DATE_OFFERNEWS, _SyncDateOfferNewsDownload);
        editor.commit();
    }

    public String getSyncDateOfferNewsDownload() {
        return pref.getString(SYNC_DATE_OFFERNEWS, "");
    }

    public void setSyncDateServices(String _SyncDateServices) {
        editor.putString(SYNC_DATE_SERVICES, _SyncDateServices);
        editor.commit();
    }
    public String getSyncDateServices() {
        return pref.getString(SYNC_DATE_SERVICES, "");
    }

    public void setCountRecordBlogs(String _CountRecordBlogs) {
        editor.putString(COUNT_RECORD_BLOGS, _CountRecordBlogs);
        editor.commit();
    }
    public String getCountRecordBlogs() {
        return pref.getString(COUNT_RECORD_BLOGS, "");
    }

    public void setCountRecordBranches(String _CountRecordBranches) {
        editor.putString(COUNT_RECORD_BRANCHES, _CountRecordBranches);
        editor.commit();
    }
    public String getCountRecordBranches() {
        return pref.getString(COUNT_RECORD_BRANCHES, "");
    }

    public void setCountRecordOffersNews(String _CountRecordOffersNews) {
        editor.putString(COUNT_RECORD_OFFERSNEWS, _CountRecordOffersNews);
        editor.commit();
    }
    public String getCountRecordOffersNews() {
        return pref.getString(COUNT_RECORD_OFFERSNEWS, "");
    }

    public void setCountServices(String _CountServices) {
        editor.putString(COUNT_SERVICES, _CountServices);
        editor.commit();
    }
    public String getCountServices() {
        return pref.getString(COUNT_SERVICES, "");
    }


    public void setBillInvoicePrefix(String _prefix) {
        editor.putString(BILL_INVOICE_PREFIX, _prefix);
        editor.commit();
    }
    public String getBillInvoicePrefix() {
        return pref.getString(BILL_INVOICE_PREFIX, "");
    }


    public void setBILL_Invoice_Edit(String _pre) {
        editor.putString(BILL_Invoice_Edit, _pre);
        editor.commit();
    }
    public String getBILL_Invoice_Edit() {
        return pref.getString(BILL_Invoice_Edit, "");
    }
}
