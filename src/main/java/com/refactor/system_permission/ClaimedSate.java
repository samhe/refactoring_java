package com.refactor.system_permission;

public class ClaimedSate extends AbstractPermissionState {
    public ClaimedSate(SystemPermission systemPermission) {
        super(systemPermission);
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
            if (profile.isUnixPermissionRequired()) {
                profile.setUnixPermissionGranted(true);
                systemPermission.setPermissionState(new UnixRequestedState(systemPermission));
                systemPermission.notifyUnixAdminsOfPermissionRequest();
            } else {
                systemPermission.setPermissionState(new GrantedState(systemPermission));
            }
        }
    }

    @Override
    public String getState() {
        return SystemPermission.CLAIMED;
    }
}
