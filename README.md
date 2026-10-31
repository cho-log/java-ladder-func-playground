# 사다리 미션

## 기능 요구사항

- 네이버 사다리 게임을 참고하여 도메인을 분석하여 구현한다.
- 사다리는 4x4 크기로 고정되고, 연결 여부는 랜덤으로 결정한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
  - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리는 크기를 입력 받아 생성할 수 있다. 
- 사다리의 시작 지점과 도착 지점을 출력한다. 
- 사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있다. 
- 사다리를 출력할 때 사람 이름도 같이 출력한다. 
- 사람 이름은 쉼표(,)를 기준으로 구분한다. 
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 폴더 구조

```
src/main/java
├── Application.java                 # 프로그램 실행 진입점, Controller 실행
│
├── controller
│   └── Controller.java              # 프로그램 흐름 관리
│
├── domain
│   ├── ColumnCount.java             # 사다리 열 개수 원시값 포장, 최소 개수 검증
│   ├── Connection.java              # 가로선 연결 상태를 나타내는 Enum
│   ├── GameResult.java              # 참여자 이름과 최종 실행 결과 매핑 및 조회
│   ├── Ladder.java                  # 사다리 일급 컬렉션, 행 관리 및 연결 상태 조회
│   ├── LadderGame.java              # 사다리 이동 및 최종 도착 위치 계산
│   ├── LadderGenerator.java         # 인접한 가로선이 겹치지 않도록 랜덤 사다리 생성
│   ├── Line.java                    # 연결 상태 일급 컬렉션, 인접 가로선 중복 검증
│   ├── Name.java                    # 참여자 이름 원시값 포장, 길이 및 공백 검증
│   ├── Names.java                   # 참여자 이름 일급 컬렉션, 중복 검증
│   ├── Result.java                  # 개별 실행 결과 원시값 포장, 공백 검증
│   ├── Results.java                 # 실행 결과 일급 컬렉션, 참여자 수와 개수 일치 검증
│   └── RowCount.java                # 사다리 행 개수 원시값 포장, 최소 개수 검증
│
└── view
    ├── InputView.java               # 참여자 이름, 실행 결과, 사다리 높이 및 조회 대상 입력
    └── OutputView.java              # 사다리 출력, 개별·전체 실행 결과 출력


src/test/java
└── domain
├── GameResultTest.java
├── LadderGameTest.java
├── LadderGeneratorTest.java
├── LadderTest.java
├── LineTest.java
├── NamesTest.java
└── ResultsTest.java
```
