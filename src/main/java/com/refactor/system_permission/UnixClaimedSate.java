package com.refactor.system_permission;

public class UnixClaimedSate implements PermissionState {
    private SystemPermission systemPermission;
    public UnixClaimedSate(SystemPermission systemPermission) {
        this.systemPermission = systemPermission;
    }

    @Override
    public void claimBy(SystemAdmin admin) {

    }

    @Override
    public void denyBy(SystemAdmin admin) {
        if(systemPermission.isClaimedBy(admin)) {
            systemPermission.setPermissionState(new DeniedState(systemPermission));
            systemPermission.notifyUserOfPermissionRequestResult();
        }
    }

    @Override
    public void grantBy(SystemAdmin admin) {
        if(systemPermission.isClaimedBy(admin)) {
            SystemProfile profile = systemPermission.getProfile();
            if (profile.isUnixPermissionRequired() && profile.isUnixPermissionGranted()) {
                systemPermission.setPermissionState(new GrantedState(systemPermission));
            }
        }
    }

    @Override
    public String getState() {
        return SystemPermission.UNIX_CLAIMED;
    }
}
