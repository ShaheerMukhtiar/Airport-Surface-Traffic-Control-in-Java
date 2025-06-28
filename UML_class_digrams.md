# 🧭 UML Diagrams – Air Traffic Control Simulation

This document presents the **UML Class Diagrams** for the `Air Traffic Control Simulation` project. These diagrams visualize the system's structure, including classes, attributes, and methods organized by packages.

---

## 📦 1. Package Structure Overview

```plaintext
📦 Global_Class
   └── 🧭 Global_clock

📦 Task_queue
   ├── 📄 Task
   ├── 📄 ControllTask
   ├── ⚙️ Task_Engine
   ├── 🔄 Task_Queue
   └── 🧩 Link_object

📦 Airplane
   ├── ✈️ Airplane
   ├── 🛬 Runway
   ├── 🛫 Taxiway
   ├── 🎛️ Traffic_Network
   ├── 📋 Airplane_List_Class
   └── 📊 Airplane_states (Enum)
```

---

## 🧭 Global_Class

### `Global_clock`

```plaintext
+-------------------------------+
|         Global_clock          |
+-------------------------------+
| - hours: int                  |
| - minutes: int                |
| - seconds: int                |
| - running: boolean (static)   |
+-------------------------------+
| + Global_clock()              |
| + Global_clock(int, int, int) |
| + getHours(): int             |
| + getMinutes(): int           |
| + getSeconds(): int           |
| + displayTime(): void         |
| + updateTime(): void          |
| + stopClock(): void           |
| + tick(): void                |
| + setClock(int, int, int): void |
| + getTime(): long             |
| + getTime(long, long): long   |
| + run(): void                 |
+-------------------------------+
```

---

## ✈️ Airplane

### `Airplane`

```plaintext
+-------------------------------+
|           Airplane            |
+-------------------------------+
| - id: int                     |
| - orientation: int            |
| - destination: String         |
| - from: String                |
| - totalcost: int              |
| - path: String                |
| - start: Global_clock         |
| - end: Global_clock           |
| - isLanding: boolean          |
| - isTakingOff: boolean        |
+-------------------------------+
| + setID(int): void            |
| + setOrientation(int): void   |
| + setDestination(String): void|
| + setFrom(String): void       |
| + setTotalCost(int): void     |
| + setPath(String): void       |
| + setStart(Global_clock): void|
| + setEnd(Global_clock): void  |
| + setLanding(boolean): void   |
| + setTakingOff(boolean): void |
| + getID(): int                |
| + getOrientation(): int       |
| + getDestination(): String    |
| + getFrom(): String           |
| + getTotalCost(): int         |
| + getPath(): String           |
| + getStart(): Global_clock    |
| + getEnd(): Global_clock      |
| + isLanding(): boolean        |
| + isTakingOff(): boolean      |
| + toString(): String          |
+-------------------------------+
```

### `Airplane_states` (Enum)

```plaintext
+-----------------------------+
|       Airplane_states      |
+-----------------------------+
| + Airphase                 |
| + Touchdown                |
| + Takeoff                  |
| + Taxii                    |
| + Hold                     |
| + Park                     |
| + FinalState               |
| + Approach                 |
| + Land                     |
+-----------------------------+
```

### `Runway` and `Taxiway`

```plaintext
+-------------------------------+
|           Runway              |
+-------------------------------+
| - isOpen: boolean             |
| - isOccupied: boolean         |
| - Id: String                  |
+-------------------------------+
| + Runway()                    |
| + Runway(boolean, boolean, String) |
| + getId(): String             |
| + setId(String): void         |
| + changeLinkstatus(): void    |
| + changeOccupancyStatus(): void |
| + isOpen(): boolean           |
+-------------------------------+

+-------------------------------+
|           Taxiway             |
+-------------------------------+
| - isOpen: boolean             |
| - isOccupied: boolean         |
| - Id: String                  |
+-------------------------------+
| + Taxiway(boolean, boolean, String) |
| + getId(): String             |
| + setId(String): void         |
| + changeLinkstatus(): void    |
| + changeOccupancyStatus(): void |
| + isopen(): boolean           |
+-------------------------------+
```

### `Traffic_Network`

```plaintext
+-------------------------------+
|        Traffic_Network        |
+-------------------------------+
| - R1: Runway (static)         |
| - R2: Runway (static)         |
| - T1: Taxiway (static)        |
| - T2: Taxiway (static)        |
+-------------------------------+
| + getR1(): Runway             |
| + setR1(Runway): void         |
| + getR2(): Runway             |
| + setR2(Runway): void         |
| + getT1(): Taxiway            |
| + setT1(Taxiway): void        |
| + getT2(): Taxiway            |
| + setT2(Taxiway): void        |
+-------------------------------+
```

### `Airplane_List_Class`

```plaintext
+----------------------------------------------+
|           Airplane_List_Class                |
+----------------------------------------------+
| - airplanes: ArrayList<Airplane>             |
| - control: Traffic_Network                   |
+----------------------------------------------+
| + createAirplane(): void                     |
| + addAirplane(Airplane): void                |
| + removeAirplane(int): void                  |
| + sendTask(Task): void                       |
| + getTargetAirplane(int): Airplane           |
| + run(): void                                |
+----------------------------------------------+
```

---

## 📄 Task_queue

### `Task`

```plaintext
+------------------------------------+
|               Task                 |
+------------------------------------+
| # primary_label: String            |
| # secondary_label: String          |
| # priority_data: int               |
| # process_time: long               |
| # execution_time: long             |
| # AirplaneID: int                  |
+------------------------------------+
| + Task()                           |
| + Task(String, String)             |
| + getPrimaryLabel(): String        |
| + getSecondaryLabel(): String      |
| + setExecutionTime(long): void     |
| + getExecutionTime(): long         |
| + calculateProcessTime(String): long |
| + getTaxiWayIDFromUser(): int      |
| + getRunWayIDFromUser(): int       |
| + getGateIDFromUser(): int         |
| + getAirplaneIDFromUser(): int     |
+------------------------------------+
```

### `ControllTask`

```plaintext
+------------------------------------+
|           ControllTask             |
+------------------------------------+
| - originalLink: int                |
| - nextLink: int                    |
| - startingTime: long               |
| - endingTime: long                 |
+------------------------------------+
| + ControllTask()                   |
| + ControllTask(String, String)     |
| + getOriginalLinkFromUser(): int   |
| + getNextLinkFromUser(): int       |
| + calculateStartingTime(): long    |
| + calculateEndingTime(): long      |
| + closeScanner(): void             |
+------------------------------------+
```

### `Task_Engine`

```plaintext
+------------------------------------+
|           Task_Engine              |
+------------------------------------+
| - landingTask: Task                |
| - exitingTask: Task                |
| - enteringLink: Task               |
| - receivingObject: Task            |
| - releasingObject: Task            |
| - closeThisLink: Task              |
| - openThisLink: Task               |
| - movingAirplane: ControllTask     |
| - holdingAirplane: ControllTask    |
| - parkingAirplane: ControllTask    |
+------------------------------------+
```

### `Task_Queue`

```plaintext
+--------------------------------------------+
|               Task_Queue                   |
+--------------------------------------------+
| - queue: ArrayList<Task> (static)          |
| - timeMark: long (static)                  |
| - queueLock: Object (static)               |
+--------------------------------------------+
| + Task_Queue()                             |
| + addTask(Task): void                      |
| + getIndex(Task): int                      |
| + dispatcher(): void                       |
| + dispatch(Task): void                     |
| + Modify_Queue_Time(Task, int): long       |
| + Display_Queue(): void                    |
| + run(): void                              |
| + main(String[]): void                     |
+--------------------------------------------+
```

### `Link_object`

```plaintext
+-------------------------------+
|         Link_object           |
+-------------------------------+
| - runwayID: int               |
| - taxiwayID: int              |
| - gate: int                   |
+-------------------------------+
| + Link_object()               |
| + Link_object(int, int, int)  |
| + getRunwayID(): int          |
| + getTaxiwayID(): int         |
| + getGateID(): int            |
| + setRunwayID(int): void      |
| + setTaxiwayID(int): void     |
| + setGateID(int): void        |
+-------------------------------+
```

---
