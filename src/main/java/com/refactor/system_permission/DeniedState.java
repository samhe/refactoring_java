package com.refactor.system_permission;

public class DeniedState implements PermissionState {
    private SystemPermission systemPermission;
    public DeniedState(SystemPermission systemPermission) {
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

    @Override
    public String getState() {
        return SystemPermission.DENIED;
    }
}
