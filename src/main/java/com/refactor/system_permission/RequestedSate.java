package com.refactor.system_permission;

public class RequestedSate implements PermissionState {
    private SystemPermission systemPermission;

    public RequestedSate(SystemPermission systemPermission) {
        this.systemPermission = systemPermission;
    }

    @Override
    public void claimBy(SystemAdmin admin) {
        systemPermission.setAdmin(admin);
        systemPermission.setPermissionState(new ClaimedSate(systemPermission));
    }

    @Override
    public void denyBy(SystemAdmin admin) {

    }

    @Override
    public void grantBy(SystemAdmin admin) {

    }
}
