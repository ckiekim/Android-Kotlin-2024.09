package com.ckworld.trotmusicapp

class SongList {
    public fun getSongList(artist: String): MutableList<SongModel> {
        val songList = mutableListOf<SongModel>();
        if (artist == "임영웅") {
            songList.add(
                SongModel(
                    "임영웅",
                    "Home",
                    "온기",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/085/111/408/85111408_1714717028079_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "임영웅",
                    "온기",
                    "온기",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/085/111/408/85111408_1714717028079_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "임영웅",
                    "사랑은 늘 도망가",
                    "신사와 아가씨 OST Part.2",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/322/594/82322594_1633671778123_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "임영웅",
                    "우리들의 블루스",
                    "IM HERO",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/638/032/82638032_1651479062721_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "임영웅",
                    "이제 나만 믿어요",
                    "내일은 미스터트롯 우승",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/410/156/81410156_1585878705990_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
        } else if (artist == "송가인") {
            songList.add(
                SongModel(
                    "송가인",
                    "한 많은 대동강",
                    "미스트롯 DEATH MATCH",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/182/154/81182154_1554431559507_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "송가인",
                    "오늘같이 좋은 날",
                    "몽(夢)",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/807/476/81807476_1608795022059_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "송가인",
                    "거기 있어줘요",
                    "잠만 자는 곳은 아닙니다",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/083/855/346/83855346_1685102243274_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "송가인",
                    "한 많은 대동강",
                    "송가인 1st ALBUM '佳人'",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/297/622/81297622_1572831730723_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
        } else {
            songList.add(
                SongModel(
                    "영탁",
                    "폼미쳤다",
                    "FORM",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/084/106/904/84106904_1690855660581_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "영탁",
                    "니가 왜 거기서 나와",
                    "니가 왜 거기서 나와",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/115/569/81115569_1539937310079_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "영탁",
                    "찐이야",
                    "내일은 미스터트롯 결승",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/388/783/81388783_1584065968502_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
            songList.add(
                SongModel(
                    "영탁",
                    "전복 먹으러 갈래",
                    "전복 먹으러 갈래",
                    "https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/525/688/82525688_1644474937805_1_600x600.JPG/dims/resize/Q_80,0"
                )
            )
        }
        return songList
    }
}