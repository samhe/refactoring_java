package com.refactor.system_permission;

public class SystemPermission {
    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";
    public final static String UNIX_REQUESTED = "UNIX_REQUESTED";
    public final static String UNIX_CLAIMED = "UNIX_CLAIMED";

    private SystemProfile profile;

    private SystemAdmin admin;

    private PermissionState permissionState;

    public SystemPermission(SystemProfile profile) {
        this.profile = profile;
        permissionState = new RequestedSate(this);
    }

    public void notifyAdminOfPermissionRequest() { }

    public void notifyUserOfPermissionRequestResult() { }

    public void notifyUnixAdminsOfPermissionRequest() { }

    public void setPermissionState(PermissionState permissionState) {
        this.permissionState = permissionState;
    }

    public SystemProfile getProfile() {
        return profile;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    public boolean isGranted() {
        return GRANTED.equals(state());
    }

    public void claimedBy(SystemAdmin admin) {
        permissionState.claimBy(admin);
    }

    public boolean isClaimedBy(SystemAdmin admin) {
        return this.admin != null && this.admin.equals(admin);
    }

    public void deniedBy(SystemAdmin admin) {
        permissionState.denyBy(admin);
    }

    public void grantedBy(SystemAdmin admin) {
        permissionState.grantBy(admin);
    }

    public String state() {
        return permissionState.getState();
    }

}
