# jboss-maven
Convert existing non-maven-archetype projects to build with maven and deploy in jboss eap 7.1

<b>Goals</b>
<ul>
  <li>Keep existing project structure. Do not move source files so that we can retain version history</li>
  <li>Do not make disruptive changes to the source files. Try to only add pom.xml so that so that we can back out easily</li>
  <li>Run only unit-test during package. Integration tests should be run separately as a differenet process</li>
  <li>Create skinny wars so that the jars are not duplicated in every war</li>
</ul>
