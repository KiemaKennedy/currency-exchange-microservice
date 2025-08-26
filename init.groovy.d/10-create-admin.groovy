
import jenkins.model.*
import hudson.security.*
cat > init.groovy.d/10-create-admin.groovy <<'EOF'

import jenkins.model.*
import jenkins.model.*
import hudson.security.*
def instance = Jenkins.getInstance()
def realm = new HudsonPrivateSecurityRealm(false)
if (realm.getAllUsers().isEmpty()) {
  realm.createAccount("admin", "Admin@12345")
}
instance.setSecurityRealm(realm)
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)
instance.save()
println("Admin user ensured: admin / Admin@12345")
