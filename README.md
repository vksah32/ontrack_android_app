On Track Android App(Developed during HackDartmouth, 2015)

<b>Our Inspiration</b><br>
We wanted a way to quickly and easily share location in the simplest possible manner. At Colby students without cars rely on “The Jitney”, a shuttle service, for all their off campus needs. In the past it’s been difficult to rely on, as it’s impossible to know the current location of the Jitney. Planning a short trip into town turned into a day long journey, with no way to know when the jitney would be available next. We were inspired by the struggles of our fellow students to make OnTrack, a simple cross platform app and web extension that allows a user (Leader) to broadcast their location to everyone who knows the name of the broadcast. Monitoring the jitney is as simple as the driver opening the app on their phone when they start a shift, and providing all potential users with the name of their session. We see the potential use cases stretching beyond Waterville, Maine, from tour guides herding their groups from place to place, to road trips, to the sharing of locations between friends. We hope you enjoy using it as much we enjoyed making it!<br>

<b>How it works</b><br>
The first iteration of On Track allows its users to create a "session" to broadcast their location to many people with a simple passcode or passphrase. When the (Android & iOS) App is launched, a user is able to become a "Leader" (black sheep) or a "Follower" (white sheep).<br>

If Leader is selected, a prompt will request a unique passphrase and update the backend database with a new active session that will broadcast the leader's position. The leader's gps coordinates will periodically be pushed to the server until he or she closes the session.<br>

If Follower is selected, a similar prompt will require a valid passphrase of an active session, then the follower will be able to track or follow an existing leader. The followers will be able to see themselves relative to the leader and can follow the session until it is closed or when they leave.<br>

There is also a web app, which is a "Follow" only implementation for the folks who don't have iOS and Android smart devices.<br>
