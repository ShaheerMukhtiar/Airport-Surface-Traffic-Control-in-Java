# 🧭 UML Diagrams – Air Traffic Control Simulation

This document captures the **UML (Unified Modeling Language)** diagrams of the Air Traffic Control Simulation Project. These diagrams help in understanding the system architecture, class relationships, and control flow.

---

## 📦 1. Package Overview

```plaintext
+------------------+
| Global_Class     |
+------------------+
| - Global_clock   |
+------------------+

+------------------+
| Task_queue       |
+------------------+
| - Task           |
| - ControllTask   |
| - Task_Engine    |
| - Task_Queue     |
| - Link_object    |
+------------------+

+------------------+
| Airplane         |
+------------------+
| - Airplane       |
| - Runway         |
| - Taxiway        |
| - Airplane_states|
| - Traffic_Network|
| - Airplane_List  |
+------------------+
