# 웹서개 모의 중간고사 — 독서 기록 관리

실제 시험 범위를 확정한 자료가 아닌 연습용 문제입니다.
권장 시간은 구현 60분, 실행 확인 15분, 서술형 및 제출 확인 15분입니다.
완성 코드를 새로 작성하는 대신 제공된 프로젝트의 TODO-01~14를 채우세요.

## 시작

- IntelliJ에서 **이 mock-exam 폴더를 별도 프로젝트로 열고** Gradle 프로젝트로 불러오세요.
- Gradle JVM과 Project SDK는 JDK 17을 사용하세요.
- `ExamApplication`의 main을 실행하고 `http://localhost:8081/books`에 접속하세요.
- 터미널에서는 상위 폴더의 wrapper로 `./gradlew -p mock-exam bootRun`을 실행할 수 있습니다.
- 8081 포트는 기존 프로젝트의 8080 포트와 충돌하지 않도록 지정했습니다.
- H2, JPA, Lombok, JavaScript 없이 Spring MVC, Thymeleaf, 메모리 Map만 사용합니다.

## 제공된 코드

```text
controller/BookController.java        URL 연결, 검증, Model 전달
service/BookService.java              등록·상태 변경·필터·집계 TODO
repository/BookRepository.java        저장소 인터페이스 (수정 불필요)
repository/MemoryBookRepository.java  Map 저장·조회 TODO
domain/Book.java                      도서와 읽음 상태
dto/BookRequest.java                  입력값과 검증 규칙 (수정 불필요)
templates/books.html                 화면 TODO
static/style.css                     상태 배지 TODO
ANSWERS.md                           서술형 답안
```

처음 실행하면 샘플 도서 2권이 표시됩니다. 등록·상태 변경은 아직 동작하지 않고,
읽음 집계는 임시로 0, 안 읽음 집계는 빈칸으로 표시됩니다.
빈 메서드와 임시 반환값은 의도적인 미구현 부분입니다.

## 문제와 배점 — 총 100점

| 문제 | TODO | 배점 | 요구사항 |
|---|---|---:|---|
| 등록 화면 | 01 | 10 | 제목·저자 label/input, name, required 지정 |
| 등록 처리 | 02~04 | 20 | Controller → Service → Repository, 고유 ID 생성 및 Map 저장 |
| 상태 변경 | 05~08 | 20 | ID로 조회, 읽음 반전, 없는 도서는 404 |
| 상태 필터 | 09~10 | 15 | 전체·읽음·안 읽음 필터 및 쿼리 파라미터 연결 |
| 전체 집계 | 11~12 | 10 | 전체·읽음·안 읽음 수를 필터와 무관하게 표시 |
| 상태 표시 | 13~14 | 10 | 상태 문구와 배지 색상 구분 |
| 코드 설명 | ANSWERS.md | 10 | 서술형 5문항 작성 |
| Git 제출 | 아래 안내 | 5 | 의미 있는 커밋 3회 이상 및 제출 저장소 push |

### 상세 요구사항

1. 제목·저자가 공백이면 저장하지 않고 오류 문구를 표시합니다. 정상 입력은 앞뒤 공백을 제거합니다.
2. 새 도서는 항상 안 읽음 상태이며, 여러 권을 등록해도 이전 도서가 사라지지 않아야 합니다.
3. 상태 변경 버튼을 누를 때마다 읽음 ↔ 안 읽음이 전환됩니다.
4. `GET /books?status=read`는 읽은 도서만, `unread`는 안 읽은 도서만 표시합니다.
5. status 생략·all·알 수 없는 값은 전체 목록을 표시합니다.
6. 집계는 항상 **전체 저장 도서** 기준입니다. 필터 결과가 0건이면 빈 목록 안내를 표시합니다.
7. 등록·상태 변경 후 `/books`로 리다이렉트합니다. 필터 유지는 필수 요구사항이 아닙니다.
8. 초기 샘플 데이터는 유지합니다. 서버 재시작 시 사용자가 등록한 데이터가 사라지는 것은 정상입니다.

## 직접 실행하며 확인할 시나리오

| 순서 | 조작 | 구현 완료 후 기대 결과 |
|---|---|---|
| 1 | 서버를 새로 실행 | 전체 2 / 읽음 1 / 안 읽음 1 |
| 2 | 제목 `  웹 개발  `, 저자 `  예찬  ` 등록 | 전체 3 / 읽음 1 / 안 읽음 2, 앞뒤 공백 제거 |
| 3 | 새 책의 상태 변경 | 전체 3 / 읽음 2 / 안 읽음 1 |
| 4 | 읽음 필터 선택 | 목록 2권, 통계는 3 / 2 / 1 유지 |
| 5 | 안 읽음 필터 선택 | 목록 1권, 통계 유지 |
| 6 | 새 책 상태를 한 번 더 변경 | 새 책은 안 읽음으로 복귀 |
| 7 | 제목에 공백만 입력해 등록 | 오류 문구 표시, 도서 수 불변 |
| 8 | `/books?status=unknown` 접속 | 전체 목록 표시 |
| 9 | 모든 도서를 읽음으로 바꾸고 안 읽음 필터 선택 | 표시할 도서 없음 안내 |
| 10 | 없는 ID에 상태 변경 POST 요청 | HTTP 404 |

없는 ID 확인 예: `curl -i -X POST http://localhost:8081/books/not-found/toggle`

## Git 제출 연습

현재 폴더는 기존 저장소 안에 있으므로 중첩 `git init`은 하지 마세요.
실제 시험에서는 교수님이 제공한 Starter 저장소와 제출 remote를 사용하세요.
이번 연습에서는 루트에서 `git diff`로 본인 변경을 확인하고 `mock-exam/`만 선택해 커밋하면 됩니다.

권장 체크포인트:

1. 화면 입력 요소 및 등록 기능 완성 → 커밋
2. 상태 변경·필터·집계·스타일 완성 → 커밋
3. 실행 확인과 ANSWERS.md 작성 완료 → 커밋

빈 커밋이나 동일 파일의 의미 없는 변경으로 횟수만 채우지 마세요.
제출 전 `git status`, `git log -3 --oneline`, 제출 remote를 확인하고 지정 브랜치로 push하세요.
이 Starter를 만드는 과정에서는 커밋이나 push를 실행하지 않습니다.

## 막힐 때 볼 힌트

- 먼저 Book과 BookRepository를 읽고 각 계층이 주고받는 타입을 확인하세요.
- 메서드 시그니처는 유지하고 TODO와 임시 반환값을 교체하세요.
- `Map.put`, `Optional.ofNullable`, `Optional.orElseThrow`를 찾아보세요.
- 필터는 반복문이나 Stream의 filter, 집계는 반복문이나 count를 사용할 수 있습니다.
- Thymeleaf의 `th:text`, `th:classappend`, 조건식을 확인하세요.
- 권장 구현 순서: **01 → 04 → 03 → 02 → 07 → 06 → 08 → 05 → 09~14**.
