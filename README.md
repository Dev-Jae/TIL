// feature 브랜치(feature/login)를 'develop' 브랜치('master' 브랜치에서 따는 것이 아니다!)에서 분기
$ git checkout -b feature/login develop

/* ~ 새로운 기능에 대한 작업 수행 ~ */

/* feature 브랜치에서 모든 작업이 끝나면 */
// 'develop' 브랜치로 이동한다.
$ git checkout develop
// 'develop' 브랜치에 feature/login 브랜치 내용을 병합(merge)한다.
// --no-ff 옵션: 아래에 추가 설명
$ git merge --no-ff feature/login
// -d 옵션: feature/login에 해당하는 브랜치를 삭제한다.
$ git branch -d feature/login
// 'develop' 브랜치를 원격 중앙 저장소에 올린다.
$ git push origin develop