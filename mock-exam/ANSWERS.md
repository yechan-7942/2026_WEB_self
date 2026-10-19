# 서술형 답안

각 문항은 본인이 작성한 코드의 클래스명·메서드명을 사용해 3~5문장으로 설명하세요.

## 1. 도서 등록 요청의 흐름
HTML form → Controller → Service → Repository 순서로 데이터가 어떻게 이동하는가?
form의 name과 BookRequest의 필드명은 어떤 관계인가?

답안:

## 2. 계층별 역할과 의존성 주입
Controller, Service, Repository의 책임은 무엇인가?
BookService가 MemoryBookRepository 대신 BookRepository에 의존하는 이유는 무엇인가?

답안:

## 3. 검증과 예외 처리
@Valid, @NotBlank, BindingResult는 어떤 역할을 하는가?
빈 제목 등록과 존재하지 않는 도서의 상태 변경은 각각 어떻게 처리했는가?

답안:

## 4. 필터와 집계
status 파라미터를 어떻게 받아 필터링했는가?
필터를 바꾸어도 상단 통계가 전체 도서 기준으로 유지되는 이유를 설명하라.

답안:

## 5. 리다이렉트와 메모리 저장소
등록 후 redirect:/books를 반환하는 이유는 무엇인가?
서버를 재시작하면 등록 데이터는 어떻게 되며, 그 이유는 무엇인가?

답안:
