package com.refactor.system_permission;

public class GrantedState implements PermissionState {
    private SystemPermission systemPermission;
    public GrantedState(SystemPermission systemPermission) {
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
        return SystemPermission.GRANTED;
    }
}
