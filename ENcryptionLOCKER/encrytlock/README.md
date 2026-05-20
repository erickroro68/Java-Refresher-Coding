## Project: Evidence Locker System  
A Java project demonstrating clean OOP design, service‑based architecture, file encryption, expiration logic, and audit logging.

## Goal
This project is designed to:
- encrypt files using AES-256
- track evidence metadata
- confirm or expire evidence
- auto-delete unconfirmed evidence after a time limit
- practice Java OOP, data structures, and project architecture

## Tech Stack
- Java
- Maven
- AES-256
- BouncyCastle

## Project Structure
src/main/java/com/evidencelocker/
- app
- core
- model
- service

## Main Classes
- `EvidenceLockerApp` -> entry point / menu flow
- `EvidenceLocker` -> main locker manager
- `EvidenceItem` -> one evidence record
- `EvidenceStatus` -> enum for evidence state
- `AuditLogEntry` -> audit log record
- `EncryptionService` -> encryption/decryption logic
- `DeletionService` -> expiration/deletion logic

## Learning Focus
This project is also helping practice:
- constructors
- methods
- class responsibilities
- Java OOP
- data structures
- system design