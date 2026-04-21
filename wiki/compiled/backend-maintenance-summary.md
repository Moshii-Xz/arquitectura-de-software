# Backend Maintenance Summary

This backend is a Spring Boot 3.4.2 Maven project running on Java 25.

Key long-term facts:

- Maven 3.9.15 is the build tool used for verification.
- No Maven Wrapper is present in the backend module.
- PostgreSQL JDBC driver is pinned to 42.7.10 to avoid CVE-2025-49146.
- Clean compile and clean test validation passed after the upgrade.
- The current test suite does not contain detected test classes.

Use the decision note in `shared/decisions/` as the canonical record for the driver upgrade.
