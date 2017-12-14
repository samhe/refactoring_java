package com.refactor.system_permission;

public class ClaimedSate implements PermissionState {
    private SystemPermission systemPermission;
    public ClaimedSate(SystemPermission systemPermission) {
        this.systemPermission = systemPermission;
    }

    @Override
    public void claimBy(SystemAdmin admin) {

    }

    @Override
    public void denyBy(SystemAdmin admin) {

    }

    @Override
    public void grantBy(SystemAdmin admin) {

    }
}
