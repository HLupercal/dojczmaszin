##implemented
- regular gear changes
- comfort, sport, manual mode
- kickdowns
- aggressive mode overrides

basic ideas:
 - `Gear` interface implementations handle upshifts, donwshifts, polimorphically changing their behavior.
 - `Transmission` interface implementations keep the particular rpm and pedal depth specifications + info on kickdowns
 - aggressive mode is implemented via a clunky decorator like object for `Gear`


plus a bunch of unit tests (they should be split way more - in general the sport transmission test works kind of like a set of e2e test scenarios which is sub optimal, but i'll never get this done if i don't stop somewhere)

to do:
- implement eco mode
- add tests
- split tests
- encapsulate hardcoded params (rpms, pedal depths) into a dedicated service
