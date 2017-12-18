package com.refactor.system_permission;

public class DeniedState extends AbstractPermissionState {
    public DeniedState(SystemPermission systemPermission) {
        super(systemPermission);
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
